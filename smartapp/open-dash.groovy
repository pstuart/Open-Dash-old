/**
 *  Copyright 2016 Open-Dash.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 *  Open-Dash API
 *
 *  Author: Open-Dash
 *  Originally from https://github.com/jodyalbritton/apismartapp/blob/master/endpoint.groovy
 */

import groovy.json.JsonBuilder

definition(
    name: "Open-Dash ${appVersion()}",
    namespace: "opendash",
    author: "Open-Dash",
    description: "Open-Dash",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    )
def appVersion() {"0.0.1"}

private def getCapabilities() {
	[   //Capability Prefrence Reference			Display Name					Subscribed Name						Subscribe Attribute        
    	["capability.accelerationSensor",			"Accelaration Sensor",			"accelerations",					"acceleration"						],
        ["capability.actuator",						"Actuator",						"actuators",						""						],
        ["capability.alarm",						"Alarm",						"alarms",							"alarm"						],
        ["capability.audioNotification",			"Audio Notification",			"audioNotifications",				""						],
        ["capability.battery",						"Battery",						"batteries",						"battery"						],
        ["capability.beacon",						"Beacon",						"beacons",							"presence"						],
        ["capability.button",						"Button",						"buttons",							"button"						],
        ["capability.carbonDioxideMeasurement",		"Carbon Dioxide Measurement",	"carbonDioxideMeasurements",		"carbonDioxide"						],
        ["capability.carbonMonoxideDetector",		"Carbon Monoxide Detector",		"carbonMonoxideDetectors",			"carbonMonoxide"						],
        ["capability.colorControl",					"Color Control",				"colorControls",					""						],
        ["capability.colorTemperature",				"Color Temperature",			"colorTemperatures",				"colorTemperature"						],
        ["capability.consumable",					"Consumable",					"consumables",						"consumable"						],
        ["capability.contactSensor",	  			"Contact",						"contactSensors",					"contact"						],
        ["capability.doorControl",	  				"Door Control",					"doorControls",						"door"						],
        ["capability.energyMeter",					"Energy Meter",					"energyMeters",						"energy"						],
        ["capability.estimatedTimeOfArrival",		"ETA",							"estimatedTimeOfArrivals",			"eta"						],
        ["capability.garageDoorControl",			"Garage Door Control",			"garageDoorControls",				"door"						],
        ["capability.illuminanceMeasurement",		"Illuminance",					"illuminanceMeasurements",			"illuminance"						],
        ["capability.imageCapture",					"Image Capture",				"imageCaptures",					"image"						],
        ["capability.indicator",					"Indicator",					"indicators",						"indicatorStatus"						],
        ["capability.lock" ,						"Lock",							"locks",							"lock"						],
        ["capability.mediaController" ,				"Media Controller",				"mediaControllers",					""						],
        ["capability.momentary" ,					"Momentary",					"momentaries",						""						],
        ["capability.motionSensor",					"Motion",						"motionSensors",					"motion"						],
        ["capability.musicPlayer",					"Music Player",					"musicPlayer",						""						],
        ["capability.pHMeasurement",				"pH Measurement",				"pHMeasurements",					"pH"						],
        ["capability.motionSensor",					"Motion",						"motionSensors",					""						],
        ["capability.powerMeter",					"Power Meter",					"powerMeters",						"power"						],
        ["capability.power",						"Power",						"powers",							"powerSource"						],
        ["capability.presenceSensor",				"Presence",						"presenceSensors",					"presence"						],
        ["capability.relativeHumidityMeasurement",	"Humidity",						"relativeHumidityMeasurements",		"humidity"						],
        ["capability.relaySwitch",					"Relay Switch",					"relaySwitches",					"switch"						],
        ["capability.sensor",						"Sensor",						"sensors",							""						],
        ["capability.shockSensor",					"Shock Sensor",					"shockSensors",						"shock"						],
        ["capability.signalStrength",				"Signal Strength",				"signalStrengths",					""						],
        ["capability.sleepSensor",					"Sleep Sensor",					"sleepSensors",						"sleeping"						],
        ["capability.smokeDetector",				"Smoke Detector",				"smokeDetectors",					"smoke"						],
        ["capability.soundSensor",					"Sound Sensor",					"soundSensors",						"sound"						],
        ["capability.speechRecognition",			"Speech Recognition",			"speechRecognitions",				"phraseSpoken"						],
        ["capability.stepSensor",					"Step Sensor",					"stepSensors",						"steps"						],
        ["capability.switch",						"Switchs", 						"switches",							"switch"						],
        ["capability.switchLevel",					"Level",						"switchLevels",						"level"						],
        ["capability.soundPressureLevel",			"Sound Pressure Level",			"soundPressureLevels",				"soundPressureLevel"						],
        ["capability.tamperAlert",					"Tamper Alert",					"tamperAlert",						"tamper"						],
        ["capability.temperatureMeasurement" , 		"Temperature", 					"temperatureMeasurements",			"temperature"						],
        ["capability.thermostat" , 					"Thermostat", 					"thermostats",						""						],
        ["capability.thermostatCoolingSetpoint" , 	"Thermostat Cooling Setpoint", 	"thermostatCoolingSetpoints",		"coolingSetpoint"						],
        ["capability.thermostatFanMode" , 			"Thermostat Fan Mode", 			"thermostatFanModes",				"thermostatFanMode"						],
        ["capability.thermostatHeatingSetpoint" , 	"Thermostat Heating Setpoint", 	"thermostatHeatingSetpoints",		"heatingSetpoint"						],
        ["capability.thermostatMode" , 				"Thermostat Mode", 				"thermostatModes",					"thermostatMode"						],
        ["capability.thermostatOperatingState",		"Thermostat Operating State",	"thermostatOperatingStates",		"thermostatOperatingState"						],
        ["capability.thermostatSetpoint",			"Thermostat Setpoint",			"thermostatSetpoints",				"thermostatSetpoint"						],
        ["capability.threeAxis",					"Three Axis",					"threeAxises",						"threeAxis"						],
        ["capability.tone",							"Tone",							"tones",							""						],
        ["capability.touchSensor",					"Touch Sensor",					"touchSensors",						"touch"						],
        ["capability.trackingMusicPlayer",			"Tracking Music Player",		"trackingMusicPlayers",				""						],
        ["capability.ultravioletIndex",				"Ultraviolet Index",			"ultravioletIndexes",				"ultravioletIndex"						],
        ["capability.soundPressureLevel",			"Sound Pressure Level",			"soundPressureLevels",				""						],
        ["capability.valve",						"Valve",						"valves",							"contact"						],
        ["capability.voltageMeasurement",			"Voltage Measurement",			"voltageMeasurements",				"voltage"						],
        ["capability.waterSensor",					"Water Sensor",					"waterSensors",						"water"						],
        ["capability.windowShade",					"Window Shade",					"windowShades",						"windowShade"						],
    ]  
}

 preferences {
     section("Allow Endpoint to Control These Things by Their Capabilities (You only need to choose one capability to get access to full device, however, selecting all capabilities will not create duplicate devices...") {
         for (cap in capabilities) {
             input cap[2], cap[0], title: "Select ${cap[1]} Devices", multiple:true, required: false
         }
    }
}

def installed() {
    initialize()
}

def updated() {
    unsubscribe()
    initialize()
}

def initialize() {
	//only subscribe to those capabilities that can send events we want to get updates from.
    for (cap in capabilities) {
    	if(cap[3] != "") {
        log.debug cap
    	subscribe(settings[cap[2]], cap[3], handleEvent)
        }
    }
    /*
    subscribe(switchs, "switch", handleSwitchEvent)
    subscribe(dimmer, "level", handleSwitchLevelEvent)
    subscribe(motion, "motion", handleMotionEvent)
    subscribe(acceleration, "acceleration", handleAccelerationEvent)
    subscribe(contact, "contact", handleContactEvent)
    subscribe(illuminant, "illuminance", handleIlluminanceEvent)
    subscribe(temperature, "temperature", handleTemperatureEvent)
    subscribe(humidity, "humidity", handleHumidityEvent)
    subscribe(lock, "locks", handleDoorLockEvent)
    subscribe(battery, "battery", handleBatteryEvent)
    subscribe(power, "power", handlePowerEvent)
    subscribe(energy, "energy", handleEnergyEvent)
    subscribe(presence, "presence", handlePresenceEvent)
    subscribe(dioxide, "dioxide", handleDioxideEvent)
    subscribe(signal, "signal", handleSignalEvent)
    subscribe(leak, "leak", handleLeakEvent)
    subscribe(sound, "sound", handleSoundEvent)
    subscribe(color, "color", handleColorEvent)
    */
}

/*
def handleIlluminanceEvent(evt) {
    logField(evt) { it.toString() }
    handleEvent(evt)
}

def handleHumidityEvent(evt) {
    logField(evt) { it.toString() }
    handleEvent(evt)
}

def handleTemperatureEvent(evt) {
    logField(evt) { it.toString() }
    handleEvent(evt)
}

def handleThermCoolPoint(evt) {
    logField(evt) { it.toString() }
    handleEvent(evt)
}

def handleContactEvent(evt) {
    logField(evt) { it == "open" ? "1" : "0" }
    handleEvent(evt)
}

def handleAccelerationEvent(evt) {
    logField(evt) { it == "active" ? "1" : "0" }
    handleEvent(evt)
}

def handleMotionEvent(evt) {
    logField(evt) { it == "active" ? "1" : "0" }
    handleEvent(evt)
}

def handleSwitchEvent(evt) {
    logField(evt) { it.toString() }
    handleEvent(evt)
}

def handleSwitchLevelEvent(evt) {
    logField(evt) { it.toString() }
    handleEvent(evt)
}

def handleDoorLockEvent(evt) {
    logField(evt) {it == "locked" ? "locked" : "unlocked" }
    handleEvent(evt)
}

def handleBatteryEvent(evt) {
    logField(evt) { it.toString() }
    handleEvent(evt)
}

def handlePowerEvent(evt) {
    logField(evt) { it.toString() }
    handleEvent(evt)
}

def handleEnergyEvent(evt) {
    logField(evt) { it.toString() }
    handleEvent(evt)
}

def handlePresenceEvent(evt) {
    logField(evt) { it.toString() }
    handleEvent(evt)
}

def handleDioxideEvent(evt) {
    logField(evt) { it.toString() }
    handleEvent(evt)
}

def handleLeakEvent(evt) {
    logField(evt) { it.toString() }
    handleEvent(evt)
}

def handleSignalEvent(evt) {
    logField(evt) { it.toString() }
    handleEvent(evt)
}

def handleSoundEvent(evt) {
    logField(evt) { it.toString() }
    handleEvent(evt)
}

def handleColorEvent(evt) {
    logField(evt) { it.toString() }
    handleEvent(evt)
}

def handleColorTemperatureEvent(evt) {
    logField(evt) { it.toString() }
    handleEvent(evt)
}
*/

def handleEvent(evt) {
	//Find what we know about evt
    /*log.debug evt
    log.debug evt.date // Sun Mar 01 22:43:37 UTC 2015
    log.debug evt.name // motion (capability type)
    log.debug evt.displayName // name of the device in ST "Office aeon multi"
    log.debug evt.value // the value of the capability type, open close inactive, active, etc.
    log.debug evt.descriptionText // ex. Master Bath 1 switch is on
    log.debug evt.description // zigbee or zwave raw data
    log.debug evt.unit // could F or others
    log.debug evt.type // null?
    log.debug evt.user // null?
    */
    //log.debug evt.jsonValue
    
    //send to webhook api
    logField(evt) { it.toString() }
    
    
    def js = eventJson(evt) //.inspect().toString()
    if (!state.updates) state.updates = []
    def x = state.updates.findAll { js.id == it.id }
    log.debug x
    
    if(x) {
    	for(i in x) {
            state.updates.remove(i) 
        }
    }
    state.updates << js
    log.debug state.updates
    
}

mappings {
    // location
    path("/locations") {
        action: [
            GET: "listLocation"
        ]
    }
    // modes
    path("/modes") {
        action: [
            GET: "listModes"
        ]
    }
    path("/modes/:id") {
        action: [
            get: "switchMode"
        ]
    }
    // hub
    path("/hubs") {
        action: [
            GET: "listHubs"
        ]
    }
    path("/hubs/:id") {
        action: [
            GET: "getHub"
        ]
    }
    // devices
   
    path("/devices") {
        action: [
            GET: "listDevices"
        ]
    }
    path("/devices/:id") {
        action: [
            GET: "listDevices",
        ]
    }
    path("/devices/:id/commands") {
        action: [
            GET: "listDeviceCommands"
        ]
    }
   
    
    path("/devices/:id/:command"){
        action: [
            GET: "sendDeviceCommand"   
        ]
    }
    
    path("/devices/:id/:command/:secondary"){
        action: [
            GET: "sendDeviceCommandSecondary"   
        ]
    }
    
    path("/devices/:id/events") {
        action: [
            GET: "listDeviceEvents"
        ]
    }
    // Routines
    path("/routines") {
        action: [
            GET: "listRoutines"
        ]
    }
    path("/routines/:id") {
        action: [
            GET: "listRoutines",
            POST: "executeRoutine"
        ]
    }
    path("/updates") {
    	action: [
        	GET: "updates"
        ]
    }
    path("/allDevices") {
    	action: [
        	GET: "allDevices"
        ]
    }
}

/****************************
* Location Methods
****************************/
def listLocation() {
    def result = [:]
    ["contactBookEnabled", "name", "temperatureScale", "zipCode"].each {
        result << [(it) : location."$it"]
    }
    result << ["latitude" : location.latitude as String]
    result << ["longitude" : location.longitude as String]
    result << ["timeZone" : location.timeZone?.getDisplayName()]
    result << ["currentMode" : getMode(location.currentMode)]

    // add hubs for this location to the result
    def hubs = []
    location.hubs?.each {
        hubs << getHub(it)
    }
    result << ["hubs" : hubs]
    log.debug "Returning LOCATION: $result"
    result
}

/****************************
* Hubs Methods
****************************/
def listHubs() {
    def id = params.id
    // if there is an id parameter, list only that hub. Otherwise list all hubs in location
    if(id) {
    def hub = location.hubs?.find{it.id == id}
          if(hub) {
              getHub(hub, true)
          } else {
              httpError(404, "hub not found")
          }
    } else {
        def result = []
        location.hubs?.each {
            result << getHub(it)
        }
        log.debug "Returning HUBS: $result"
        result
    }
}

private getHub(hub, explodedView = false) {
    def result = [:]
    //put the id and name into the result
    ["id", "name"].each {
        result << [(it) : hub."$it"]
    }

    // if we want detailed information about this hub
    if(explodedView) {
        ["firmwareVersionString", "localIP", "localSrvPortTCP", "zigbeeEui", "zigbeeId"].each {
            result << [(it) : hub."$it"]
        }
        result << ["type" : hub.type as String]
    }
    log.debug "Returning HUB: $result"
    result
}

/****************************
* Modes Methods
****************************/
def listModes() {
    def id = params.id
    // if there is an id parameter, list only that mode. Otherwise list all modes in location
    if(id) {
        def themode = location.modes?.find{it.id == id}
        if(themode) {
            getMode(themode, true)
        } else {
            httpError(404, "mode not found")
        }
    } else {
        def result = []
        location.modes?.each {
            result << getMode(it)
        }
        log.debug "Returning MODES: $result"
        result
    }
}

private getMode(mode, explodedView = false) {
    def result = [:]
    ["id", "name"].each {
        result << [(it) : mode."$it"]
    }

    if(explodedView) {
        ["locationId"].each {
            result << [(it) : mode."$it"]
        }
    }
    log.debug "Returning MODE: $result"
    result
}

def switchMode() {
    def id = params.id
    def mode = location.modes?.find{it.id == id}
    if(mode) {
        log.debug "Setting mode to $mode.name in location: $location.name"
        location.setMode(mode.name)
        render contentType: "text/html", status: 204, data: "No Content"
    } else {
        httpError(404, "mode not found")
    }
}

/****************************
* Routine Methods
****************************/
def listRoutines() {
    def id = params.id
    def results = []
    // if there is an id parameter, list only that routine. Otherwise list all routines in location
    if(id) {
        def routine = location.helloHome?.getPhrases().find{it.id == id}
        def myRoutine = [:]
        if(!routine) {
            httpError(404, "Routine not found")
        } else {
            getRoutine(routine)
        }
    } else {
        location.helloHome?.getPhrases().each { routine ->
            results << getRoutine(routine)
        }
        log.debug "Returning ROUTINES: $results"
        results
    }
}

private getRoutine(routine) {
    def result = [:]
    ["id", "label"].each {
        result << [(it) : routine."$it"]
    }
    log.debug "Returning ROUTINE: $result"
    result
}

def executeRoutine() {
    def id = params.id
    def routine = location.helloHome?.getPhrases().find{it.id == id}
    if(!routine) {
        httpError(404, "Routine not found")
    } else {
        log.debug "Executing Routine: $routine.label in location: $location.name"
        location.helloHome?.execute(routine.label)
        render contentType: "text/html", status: 204, data: "No Content"
    }
}

/****************************
* Device Methods
****************************/
def listDeviceTypes() {
    def results = []
    settings.each {
        results << it.key
    }
    log.debug "Returning TYPES: $results"
    results
}

def listDevices() {
    def id = params.id
    // if there is an id parameter, list only that device. Otherwise list all devices in location
    if(id) {
        def device = allDevices?.find{it.id == id}
        deviceItem(device, true)
    } else {
        def result = []
        result << allDevices.collect{deviceItem(it, false)}
        log.debug "Returning DEVICES: $result"
        result[0]
    }
}

private deviceItem(device, explodedView) {
    if (!device) return null
    def results = [:]
    ["id", "name", "displayName"].each {
        results << [(it) : device."$it"]
    }

    if(explodedView) {
        def attrsAndVals = [:]
        device.supportedAttributes?.each {
            attrsAndVals << [(it.name) : device.currentValue(it.name)]
        }

        results << ["attributes" : attrsAndVals]
    }
    log.debug "Returning DEVICE: $results"
    results
}

def listDeviceEvents() {
    def numEvents = 20
    def id = params.id
    def device = allDevices?.find{it.id == id}

    if (!device) {
        httpError(404, "Device not found")
    } else {
        log.debug "Retrieving last $numEvents events"
        def events = device.events(max: numEvents)
        def result = events.collect{item(device, it)}
        log.debug "Returnings EVENTS: $result"
        result
    }
}

private getAllDevices() {
    //contactSensors + presenceSensors + temperatureSensors + accelerationSensors + waterSensors + lightSensors + humiditySensors

     def dev_list =
     	([] + switches
        + dimmers
        + motions
        + accelerations
        + contacts
        + illuminants
        + temperatures
        + humidities
        + locks 
        + alarms
        + batteries
        + thermostats 
        + medias 
        + musics 
        + speeches 
        + colors 
        + valves
        + waters 
        + presences 
        + leaks)?.findAll()?.unique { it.id }
        
        return dev_list
}

private item(device, s) {
    device && s ? [device_id: device.id, 
                   label: device.displayName, 
                   name: s.name, value: s.value, 
                   date: s.date, stateChange: s.stateChange, 
                   eventSource: s.eventSource] : null
}

def listDeviceCommands() {
    def id = params.id
    def device = allDevices?.find{it.id == id}
    def result = []
    if(!device) {
        httpError(404, "Device not found")
    } else {
        device.supportedCommands?.each {
            result << ["command" : it.name, "params"  : [:]]
        }
    }
    log.debug "Returning COMMANDS: $result"
    result
}

def sendDeviceCommand() {
    def id = params.id
     def device = allDevices?.find{it.id == id}
    def command = params.command
    def secondary_command = params.level
    
    device."$command"()
    if(!command) {
        httpError(404, "Device not found")
    }
    if(!device) {
        httpError(404, "Device not found")
    } else {
        log.debug "Executing command: $command on device: $device.displayName"
    }
}

def sendDeviceCommandSecondary() {
    def id = params.id
    def device = allDevices?.find{it.id == id}
    def command = params.command
    def secondary = params.secondary.toInteger()
    
    device."$command"(secondary)
    if(!command) {
        httpError(404, "Device not found")
    }
    if(!device) {
        httpError(404, "Device not found")
    } else {
        log.debug "Executing with secondary command: $command $secondary on device: $device.displayName"
    }
}

def updates() {
	//render out json of all updates since last html loaded
    render contentType: "text/json", data:  "updates(" +new JsonBuilder(state.updates).toPrettyString() + ");"
    //render contentType: "text/plain", data:  new JsonBuilder(state.updates).toPrettyString()
}

def allDevices() {
	def allAttributes = []
    def uniqueDevices = settings.collect { k, devices -> devices.findAll{k != "capability"} }.flatten().unique { it.id }
    log.debug "${uniqueDevices.size()} Unique Devices" // is $uniqueDevices"
    
    uniqueDevices.each {
        it.collect{ i ->
            def deviceData = [:]
            
            deviceData << [name: i?.displayName, label: i?.name, type: i?.typeName, id: i?.id, date: i?.events()[0]?.date]
            def attributes = [:]
            i.supportedAttributes.each {
            	attributes << [(it.toString()) : i.currentState(it.toString())?.value]
            }
            deviceData << [ "attributes" : attributes ]
            deviceData << [ "commands" : i.supportedCommands.toString() ]
            //log.debug deviceData
            allAttributes << deviceData
    	}
    }
    render contentType: "text/json", data: new JsonBuilder(allAttributes).toPrettyString()
    //render contentType: "text/json", data:  "updates(" +new JsonBuilder(allAttributes) + ");"
}


private eventJson(evt) {
	def update = [:]
    update.id = evt.deviceId
    update.name = evt.name
    update.value = evt.value
    update.name = evt.displayName
    update.date = evt.isoDate
    //log.debug update
    return update
}

// Callback to some url 
private logField(evt, Closure c) {
    //log.debug "The souce of this event is ${evt.source} and it was ${evt.id}"

    //httpPostJson(uri: "#####SEND EVENTS TO YOUR ENDPOINT######",   body:[source: "smart_things", device: evt.deviceId, eventType: evt.name, value: evt.value, event_date: evt.isoDate, units: evt.unit, event_source: evt.source, state_changed: evt.isStateChange()]) {
    //    log.debug evt.name+" Event data successfully posted"
    //}
}
