var fs = require('fs');

module.exports = { readFiles : 

function readFiles(files, callback) {
  var filesLeft = files.length;
  var contents = {};
  var error = null;

  var processContent = function(filePath) {
    return function(err, data) {
      // an error was previously encountered and the callback was invoked
      if (error !== null) { return; }

  // an error happen while trying to read the file, so invoke the callback
  if (err) {
    error = err;
    return callback(err);
  }

  contents[filePath] = data;

  // after the last file read was executed, invoke the callback
  if (!--filesLeft) {
    callback(null, contents);
  }
};

  };

  files.forEach(function(filePath) {
      fs.readFile(filePath, {encoding: 'utf-8'},processContent(filePath));
  });
}
};