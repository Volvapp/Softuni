function attachEvents() {
  document
    .querySelector("#submit")
    .addEventListener("click", getWeatherDataForLocation);

  const weatherSymbols = {
    Sunny: "\u2600",
    "Partly sunny": "\u26C5",
    Overcast: "\u2601",
    Rain: "\u2614",
  };

  async function getWeatherDataForLocation() {
    const locationName = document.querySelector("#location").value;
    const locationResponse = await (
      await fetch(`http://localhost:3030/jsonstore/forecaster/locations`)
    ).json();

    const location = locationResponse.find(
      (l) => l.name.toLowerCase() === locationName.toLowerCase()
    );

    const currentConditionsResponse = await (
      await fetch(
        `http://localhost:3030/jsonstore/forecaster/today/${location.code}`
      )
    ).json();

    const threeDayForecastResponse = await (
      await fetch(
        `http://localhost:3030/jsonstore/forecaster/upcoming/${location.code}`
      )
    ).json();

    //CURRENT

    const forecastContainer = document.querySelector("#forecast");
    forecastContainer.style.display = "block";

    const cuurentWeatherContainer = document.createElement("div");
    cuurentWeatherContainer.classList.add("forecasts");

    const weatherSymbol = document.createElement("span");
    weatherSymbol.classList.add("conadition", "symbol");
    weatherSymbol.textContent =
      weatherSymbols[currentConditionsResponse.forecast.condition];

    const dataHolder = document.createElement("span");
    dataHolder.classList.add("condition");

    const name = document.createElement("span");
    name.classList.add("forecast-data");
    name.textContent = currentConditionsResponse.name;
    dataHolder.appendChild(name);

    const temp = document.createElement("span");
    temp.classList.add("forecast-data");
    temp.textContent = `${currentConditionsResponse.forecast.low}\u00B0/${currentConditionsResponse.forecast.high}\u00B0`;
    dataHolder.appendChild(temp);

    const condition = document.createElement("span");
    condition.classList.add("forecast-data");
    condition.textContent = currentConditionsResponse.forecast.condition;
    dataHolder.appendChild(condition);

    cuurentWeatherContainer.appendChild(weatherSymbol);
    cuurentWeatherContainer.appendChild(dataHolder);
    document.querySelector("#current").appendChild(cuurentWeatherContainer);

    //UPCOMMING

    const forecastInfoContainer = document.createElement("div");
    forecastInfoContainer.classList.add("forecast-info");

    let upcomingConditions = threeDayForecastResponse.forecast;

    upcomingConditions.forEach((forecast) => {
      const upcoming = document.createElement("span");
      upcoming.classList.add("upcoming");

      const upcomingSymbol = document.createElement("span");
      upcomingSymbol.classList.add("symbol");
      upcomingSymbol.textContent = weatherSymbols[forecast.condition];
      upcoming.appendChild(upcomingSymbol);

      const upcomingTemp = document.createElement("span");
      upcomingTemp.classList.add("forecast-data");
      upcomingTemp.textContent = `${forecast.low}\u00B0/${forecast.high}\u00B0`;
      upcoming.appendChild(upcomingTemp);

      const upcomingCondition = document.createElement("span");
      upcomingCondition.classList.add("forecast-data");
      upcomingCondition.textContent = forecast.condition;
      upcoming.appendChild(upcomingCondition);

      forecastInfoContainer.appendChild(upcoming);
    });

    document.querySelector("#upcoming").appendChild(forecastInfoContainer);
  }
}

attachEvents();
