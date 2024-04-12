function solve(entries) {
  let parkingLot = [];

  for (const entry of entries) {
    const [direction, carNumber] = entry.split(', ');

    if (direction === "IN") {
      if (!parkingLot.includes(carNumber)) {
        parkingLot.push(carNumber);
      }
    } else if (direction === "OUT") {
      const carIndex = parkingLot.indexOf(carNumber);
      if (carIndex !== -1) {
        parkingLot.splice(carIndex, 1);
      }
    }
  }

  if (parkingLot.length === 0) {
    console.log("Parking Lot is Empty");
  } else {
    parkingLot.sort((a, b) => a.localeCompare(b));
   parkingLot.forEach(car => console.log(car))
  }
}

solve([
  "IN, CA2844AA",
  "IN, CA1234TA",
  "OUT, CA2844AA",
  "IN, CA9999TT",
  "IN, CA2866HI",
  "OUT, CA1234TA",
  "IN, CA2844AA",
  "OUT, CA2866HI",
  "IN, CA9876HH",
  "IN, CA2822UU",
]);
