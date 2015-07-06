# inAppPdf Plugin

This plugin use for Android the native system to open pdf with external apps and for ios use a new custom web view to open the pdf.

## Installation

    cordova plugins install org.cloudsky.cordovaplugins.zbar

## License

This plugin is released under the Apache 2.0 license

## API

### Scan barcode

    cloudSky.zBar.scan(params, onSuccess, onFailure)

Arguments:

- **params**: Optional parameters:

    ```javascript
    {
        text_title: "OPTIONAL Title Text - default = 'Scan QR Code'", // Android only
        text_instructions: "OPTIONAL Instruction Text - default = 'Please point your camera at the QR code.'", // Android only
        camera: "front" || "back" // defaults to "back"
        flash: "on" || "off" || "auto" // defaults to "auto". See Quirks
		drawSight : "true" || "false" //default use true, create a red/green sight to center barcode
    }
    ```

- **onSuccess**: function (s) {...} _Callback for successful scan._
- **onFailure**: function (s) {...} _Callback for cancelled scan or error._

Return:

- success('scanned bar code') _Successful scan with value of scanned code_
- error('cancelled') _If user cancelled the scan (with back button etc)_
- error('misc error message') _Misc failure_

Status:

- Android: DONE
- iOS: DONE

Quirks:

- __Android__: The app must have installed at least one pdf reader.
