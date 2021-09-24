const searchForm = document.querySelector(".search-form");
const searchBar = document.querySelector(".search-bar input");
const searchResults = document.querySelector(".search-bar-results");
const link = document.querySelector(".search-form a")

const testData = ["London", "Manchester", "Liverpool"]

searchBar.onkeyup = (e) => {
    let query = e.target.value;
    let emptyArray = [];

    if (query) {
        emptyArray = testData.filter((data) => {
            return data.toLocaleLowerCase().startsWith(query.toLocaleLowerCase());
        });

        emptyArray = emptyArray.map((data) => {
            return data = `<li>${data}</li>`;
        });

        searchForm.classList.add("active");
        showResults(emptyArray);
        let allList = searchResults.querySelectorAll("li");
        for (let i = 0; i < allList.length; i++) {
            allList[i].setAttribute("onclick", "select(this)");
        }
    } else {
        searchForm.classList.remove("active");
    }
}

function select(element) {
    searchBar.value = element.textContent;

    searchForm.classList.remove("active");
}

function showResults(list) {
    let listData;

    if (!list.length) {
        let userValue = searchBar.value;
        listData = `<li>${userValue}</li>`
    } else {
        listData = list.join('');
    }

    searchResults.innerHTML = listData;
}
