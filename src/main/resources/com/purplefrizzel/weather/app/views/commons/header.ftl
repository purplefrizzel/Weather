<#macro header>
    <header>
        <script defer src="/assets/js/search.js"></script>
        <form class="search-form" method="post" action="/search">
            <div class="search-bar text-sm">
                <i onclick="getLocation()" id="search-icon" class="fas fa-search-location" style="color: #929da3"></i>
                <input id="query" name="query" placeholder="Search new place" />
            </div>
        </form>
    </header>
</#macro>
