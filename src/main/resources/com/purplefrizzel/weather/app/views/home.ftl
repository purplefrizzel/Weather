<#-- @ftlvariable name="Home" type="com.purplefrizzel.weather.app.views.HomeView" -->
<#import "commons/index.ftl" as index>

<@index.content title="Home">
    <form class="search-form" method="post" action="/search">
        <div class="search-bar text-sm">
            <i onclick="getLocation()" id="search-icon" class="fas fa-search-location" style="color: #929da3"></i>
            <input id="query" name="query" placeholder="Search new place" />
        </div>
    </form>

    <div class="text-4xl" style="padding: 20px">
        <span class="font-light">Weather</span>
        <span class="font-bold">Forecast</span>
    </div>

    <div class="weather-cards">
        <a href="/" title="Weather in New York" class="weather-card">
            <div class="weather-card__condition">
                <h2>20&deg;</h2>
                <div title="Sunny" class="icon"></div>
            </div>

            <div class="weather-card__location">
                <p class="city">New York</p>
                <p class="country">USA</p>
            </div>
        </a>

        <div class="weather-card">
            <div class="weather-card__condition">
                <h2>20&deg;</h2>
                <div class="icon"></div>
            </div>

            <div class="weather-card__location">
                <p class="city">New York</p>
                <p class="country">USA</p>
            </div>
        </div>

        <div class="weather-card">
            <div class="weather-card__condition">
                <h2>20&deg;</h2>
                <div class="icon"></div>
            </div>

            <div class="weather-card__location">
                <p class="city">New York</p>
                <p class="country">USA</p>
            </div>
        </div>
    </div>

    <script type="application/javascript">
        function getLocation() {
            window.navigator.geolocation.getCurrentPosition((response) => {
                console.log(response.coords);
            }, (error) => {
                console.error(error);
            }, {
                enableHighAccuracy: true
            });
        }
    </script>
</@index.content>