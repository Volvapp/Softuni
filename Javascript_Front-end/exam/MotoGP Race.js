function solve(input) {
  const commands = {
    StopForFuel: stopForFuel,
    Overtaking: overtake,
    EngineFail: engineFail,
  };

  const n = Number(input.shift());
  const riders = {};

  for (let i = 0; i < n; i++) {
    const [rider, fuelCapacity, position] = input.shift().split("|");
    riders[rider] = {
      fuelCapacity: Number(fuelCapacity),
      position: Number(position),
      originalPosition: Number(position),
      points: 0,
    };
  }

  for (const inputLine of input) {
    if (inputLine === "Finish") {
      break;
    }
    const [command, ...args] = inputLine.split(" - ");
    if (commands[command]) {
      commands[command](riders, ...args);
    } else {
      console.log(`Invalid command: ${command}`);
    }
  }

  // Calculate points for each rider based on their initial and final positions
  let positionPoints = 100;
  for (const rider in riders) {
    riders[rider].points = positionPoints;
    positionPoints -= 10;
  }

  // Sort finished riders based on points and original positions
  const sortedRiders = Object.entries(riders)
    .map(([name, data]) => ({
      name,
      position: data.position,
      points: data.points,
    }))
    .sort((a, b) => b.points - a.points || a.position - b.position);

  for (const rider of sortedRiders) {
    console.log(`${rider.name}`);
    console.log(`  Final position: ${rider.position}`);
  }

  function stopForFuel(riders, rider, minFuel, newPosition) {
    if (!riders[rider]) {
      console.log(`${rider} is not a valid rider.`);
      return;
    }

    const minFuelInt = parseInt(minFuel);
    const newPositionInt = parseInt(newPosition);

    if (riders[rider].fuelCapacity < minFuelInt) {
      console.log(
        `${rider} stopped to refuel but lost his position, now he is ${newPositionInt}.`
      );
      riders[rider].position = newPositionInt;
    } else {
      console.log(`${rider} does not need to stop for fuel!`);
    }
  }

  function overtake(riders, rider1, rider2) {
    if (!riders[rider1] || !riders[rider2]) {
      console.log(
        `One of the specified riders (${rider1} or ${rider2}) does not exist.`
      );
      return;
    }

    if (riders[rider1].position < riders[rider2].position) {
      [riders[rider1].position, riders[rider2].position] = [
        riders[rider2].position,
        riders[rider1].position,
      ];
      console.log(`${rider1} overtook ${rider2}!`);
    }
  }

  function engineFail(riders, rider, lapsLeft) {
    if (!riders[rider]) {
      console.log(`${rider} is not a valid rider.`);
      return;
    }

    console.log(
      `${rider} is out of the race because of a technical issue, ${lapsLeft} laps before the finish.`
    );
    delete riders[rider];
  }
}
