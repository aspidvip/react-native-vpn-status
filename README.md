
# react-native-vpn-status

Get current VPN status

## Getting started

`$ npm install react-native-vpn-status --save`

or 

`$ yarn add react-native-vpn-status`

and 

`$ cd ios && pod install`


## Usage
```javascript
import { detectVPN } from 'react-native-vpn-status';

* Example
async function getStatusVPN() {
	const isStatus = await detectVPN(); // bool
}
getStatusVPN();
```
