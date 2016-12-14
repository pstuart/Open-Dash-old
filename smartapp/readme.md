SmartThings Open-Dash API Documentation

Endpoints are accessable via https://graph.api.smartthings.com:443/api/smartapps/installations/[smartapp installed uuid]/[endpoint]/

You muse have the header:
authorization: Bearer [token]  
where the [token] is the completed oauth2 authentication flow to the Smartapp.

NOTE:  All endpoints right now only respond to a GET, this will be fixed later.

All parameters that have a ":" should be get vars, example endpoint /devices/:id should be [endpoint_url]/[smartapp_uuid]/devices?id=[uuid]

Endpoints
/locations
Get all locations attached to to authenticated account

returns json

example:
{
	"contactBookEnabled": true,
	"name": "Home",
	"temperatureScale": "F",
	"zipCode": "55446",
	"latitude": "44.07619000",
	"longitude": "-97.50923000",
	"timeZone": "Central Standard Time",
	"currentMode": {
		"id": "[uuid]",
		"name": "Home"
	},
	"hubs": [{
			"id": "[uuid]",
			"name": "Home Hub"
		}
	]
}

/modes
Get all modes attached to this account

returns json

example:
[{
		"id": "[uuid]",
		"name": "Home"
	}, {
		"id": "[uuid]",
		"name": "Night"
	}, {
		"id": "[uuid]",
		"name": "Away"
	}
]

/modes/:id
Set the mode via its UUID from /modes

returns html  Need to test

/hubs
Get all hubs attached to this account

returns json

example:
[{
		"id": "[uuid]",
		"name": "Home Hub",
		"firmwareVersionString": "000.016.00009",
		"localIP": "[redacted]",
		"localSrvPortTCP": "39500",
		"zigbeeEui": "[redacted]",
		"zigbeeId": "[redacted]",
		"type": "PHYSICAL"
	}
]

/hubs/:id
Get hub information based on id

returns json

example:
[{
		"id": "[uuid]",
		"name": "Home Hub",
		"firmwareVersionString": "000.016.00009",
		"localIP": "[redacted]",
		"localSrvPortTCP": "39500",
		"zigbeeEui": "[redacted]",
		"zigbeeId": "[redacted]",
		"type": "PHYSICAL"
	}
]

/routines
Get all routines associated with Account

returns json

example:
[{
		"id": "[uuid]",
		"label": "I'm Back!"
	},  {
		"id": "[uuid]",
		"label": "Good Night!"
	}, {
		"id": "[uuid]",
		"label": "Goodbye!"
	}
]


/routines/:id
GET
Get routine information
returns json

example:
{"id":"[uuid]","label":"I'm Back!"}

POST
Execute routine
returns html
success: 204
error: 404

/devices
Get list of devices

/devices/:id
Get device info

/devices/:id/commands
Get device commands

/devices/:id/:command
Sends command to device id

/devices/:id/:command/:secondary
Sends Secondary command to device id

/devices/:id/events
Get Device Events

/updates
Get last update for each device

/allDevices
Get all devices subscribed to, with full details

/devicetypes
Get devicetype names for all subscribed devices
