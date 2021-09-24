<#-- @ftlvariable name="Search" type="com.purplefrizzel.weather.app.views.SearchView" -->
<#import "commons/index.ftl" as index>

<@index.content title="Search Resutls for \"${query}\"">
    <div class="results-title text-4xl">
        <span class="font-light">Results for </span>
        <span class="font-bold">"${query}"</span>
    </div>

    <div class="results">
        <div class="no-results">
            <p>Sorry but no results could be found for "${query}".</p>
        </div>

        <div title="Weather in Manchester" class="result">
            <div class="location">
                <p class="text-3xl font-reg">Manchester</p>
                <p class="font-thin">Manchester</p>
            </div>

            <div class="conditions">
                <div title="Chance of rain">
                    <p><i class="fas fa-tint"></i> 20%</p>
                </div>
                <div title="Wind speed">
                    <p><i class="fas fa-wind"></i> 7km/h</p>
                </div>
                <div title="Air Quality Index">
                    <p>AQI 2</p>
                </div>
            </div>

            <div title="Add to your places" class="add">
                <i class="fas fa-plus"></i>
            </div>
        </div>

        <div title="Weather in Manchester" class="result">
            <div class="location">
                <p class="text-3xl font-reg">Manchester</p>
                <p class="font-thin">Manchester</p>
            </div>

            <div class="conditions">
                <div title="Chance of rain">
                    <p><i class="fas fa-tint"></i> 20%</p>
                </div>
                <div title="Wind speed">
                    <p><i class="fas fa-wind"></i> 7km/h</p>
                </div>
                <div title="Air Quality Index">
                    <p>AQI 2</p>
                </div>
            </div>

            <div title="Add to your places" class="add">
                <i class="fas fa-plus"></i>
            </div>
        </div>
    </div>
</@index.content>