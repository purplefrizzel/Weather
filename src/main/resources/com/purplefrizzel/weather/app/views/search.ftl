<#-- @ftlvariable name="query" type="java.lang.String" -->
<#-- @ftlvariable name="locations" type="com.purplefrizzel.weather.api.models.location.WeatherLocation[]" -->
<#-- @ftlvariable name="locationsLength" type="java.lang.Integer" -->
<#import "commons/index.ftl" as index>

<@index.content title="Search Results for \"${query}\"">
    <div class="results-title text-4xl">
        <span class="font-light">Results for </span>
        <span class="font-bold">"${query}"</span>
    </div>

    <div class="results">
        <#if locationsLength <= 0>
            <div class="no-results">
                <p>Sorry but no results could be found for "${query}".</p>
            </div>
        </#if>

        <#list locations as location>
            <div title="Weather in ${location.name}" class="result">
                <div class="location">
                    <p class="text-3xl font-reg">${location.name}</p>
                    <p class="font-thin">${location.metadata.container}</p>
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
            </div>
        </#list>
    </div>
</@index.content>