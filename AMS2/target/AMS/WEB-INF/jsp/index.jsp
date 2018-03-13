<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html"  pageEncoding="UTF-8"%>
<!--<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">-->
<%@ include file="/WEB-INF/pages/includes.jsp" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=10, user-scalable=yes">
        <meta charset="UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/minilogo.png">
        <link rel="stylesheet" href="sass/common.scss">
        <title>Sistema Inventario</title> 
        <script type="text/javascript">
            var Ext = Ext || {}; // Ext namespace won't be defined yet...

            // This function is called by the Microloader after it has performed basic
            // device detection. The results are provided in the "tags" object. You can
            // use these tags here or even add custom tags. These can be used by platform
            // filters in your manifest or by platformConfig expressions in your app.
            //
            Ext.beforeLoad = function (tags) {

                var s = location.search, // the query string (ex "?foo=1&bar")
                        profile;

                // For testing look for "?classic" or "?modern" in the URL to override
                // device detection default.
                //
                if (s.match(/\bclassic\b/)) {
                    profile = 'classic';
                }
                else if (s.match(/\bmodern\b/)) {
                    profile = 'modern';
                }
                // uncomment this if you have added native build profiles to your app.json
                /*else if (tags.webview) {
                 if (tags.ios) {
                 profile = 'ios';
                 }
                 // add other native platforms here
                 }*/
                else {
                    //profile = tags.desktop ? 'classic' : 'modern';
                    profile = tags.phone ? 'modern' : 'classic';
                }

                Ext.manifest = profile; // this name must match a build profile name

                // This function is called once the manifest is available but before
                // any data is pulled from it.
                //
                //return function (manifest) {
                // peek at / modify the manifest object
                //};
            };
        </script>
<!-- The line below must be kept intact for Sencha Cmd to build your application -->
        <script id="microloader" type="text/javascript" src="bootstrap.js"></script> 

    </head>
    <body class="preload-body"> 
        <div style="position: absolute; height:44px; background-color:#35baf6; width: 100%; margin: 0px;padding: 0px">
            <span style="width: 100%; height: 100%; position: absolute; text-align: center; color: #f0f0f0;    font-size: 16px;font-weight: 500;line-height: 44px;">Espere...</span>
        </div>

        <img src="resources/images/loading.gif" style="height:100px;width:100px;margin-left:47%;margin-top:240px">
    </body>

</html>
