/// <reference path="typings/node/node.d.ts"/>
/*
 OAUTH Client Example
 needs 
 npm install express
 npm install request
 npm install JSON
 npm install simple-oauth2
*/


// expected commandline node.js script CLIENT_ID CLIENT_SECRET
if (process.argv.length != 4) {
  console.log("usage: " + process.argv[0] + " " + process.argv[1] + " CLIENT_ID CLIENT_SECRET");
  process.exit();
}

var CLIENT_ID = process.argv[2];
var CLIENT_SECRET = process.argv[3];

var request = require('request');
var express = require('express'),
  app = express();
var token;
var accessURL;
var apiURL;
var endpoints_uri = 'https://graph.api.smartthings.com/api/smartapps/endpoints';

var oauth2 = require('simple-oauth2')({
  clientID: CLIENT_ID,
  clientSecret: CLIENT_SECRET,
  site: 'https://graph.api.smartthings.com'
});
 
// Authorization uri definition 
var authorization_uri = oauth2.authCode.authorizeURL({
  redirect_uri: 'http://localhost:3000/callback',
  scope: 'app',
  state: '3(#0/!~'
});
 
// Initial page redirecting to Github 
app.get('/auth', function (req, res) {
  res.redirect(authorization_uri);
});
 
// Callback service parsing the authorization token and asking for the access token 
app.get('/callback', function (req, res) {
  var code = req.query.code;
  // console.log('/callback got code' + code);
  oauth2.authCode.getToken({
    code: code,
    redirect_uri: 'http://localhost:3000/callback'
  }, saveToken);

  function saveToken(error, result) {
    if (error) { console.log('Access Token Error', error.message); }

    // result.access_token is the token, get the endpoint
    token = result.access_token;
    var sendreq = { method: "GET", uri: endpoints_uri + "?access_token=" + result.access_token };
    request(sendreq, function (err, res1, body) {
      var endpoints = JSON.parse(body);
	  console.log(endpoints);
      // we just show the final access URL and Bearer code
      var access_url = endpoints[0].url
	  
	accessURL = 'https://graph.api.smartthings.com/' + access_url;
	apiURL = endpoints[0].uri;
      res.send('<pre>https://graph.api.smartthings.com/' + access_url + '</pre><br><pre>Token ' + token + '</pre><br/><a href="/devices">Get Devices</a><br/><a href="/endpoints">Get Endpoints</a><br/>');
    });
  }
});

app.get('/', function (req, res) {
  res.send('<a href="/auth">Connect with SmartThings</a>');
});

app.get('/endpoints', function(req, res) {
	var response = "";
	var options = {
		uri: endpoints_uri + "?access_token=" + token,
		method: 'GET',
		headers: {
			'Content-Type': 'application/json',
			'Authorization': 'Bearer ' + token
		}
	};
	request(options, function(err, res1, body) {
		var endpoints = JSON.parse(body);
		res.send('endpoints are: ' + endpoints[0].location.name + endpoints[0].uri);
	});
	
});

app.get('/devices', function(req, res) {
	var response = "";
	var options = {
		uri: apiURL + "/devices" + "?access_token=" + token,
		method: 'GET',
		headers: {
			'Content-Type': 'application/json',
			'Authorization': 'Bearer ' + token
		}
	};
	request(options, function(err, res1, body) {
		var devices = JSON.parse(body);
		console.log(devices);
		var deviceHTML = "<div>Devices</div>";
		for(var i = 0; i < devices.length; i++) {
			deviceHTML += "<div>id: "+devices[i].id + " Name: " + devices[i].displayName + " Type: " + devices[i].name + "</div>";
		}
		res.send(deviceHTML);
	});
	
});


app.listen(3000);

console.log('Express server started on port 3000');
