<#import "header.ftl" as header>

<#macro content title>
    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Weather - ${title}</title>
        <link rel="icon" content="image/x-icon" href="/favicon.ico" />

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,600;1,300;1,400;1,600&display=swap" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flexboxgrid/6.3.1/flexboxgrid.min.css" type="text/css" >

        <link rel="stylesheet" content="text/css" href="/assets/css/main.css" />

        <script crossorigin="anonymous" src="https://kit.fontawesome.com/579e67a2b1.js"></script>
        <script defer crossorigin="anonymous" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script defer crossorigin="anonymous" src="https://unpkg.com/alpinejs@3.x.x/dist/cdn.min.js"></script>

        <script src="/assets/js/app.js"></script>
        <script src="/assets/js/alert.js"></script>
    </head>
    <body>
        <main class="app">
            <@header.header />
            <#nested>
        </main>
    </body>
    </html>
</#macro>
