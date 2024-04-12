function solve(password) {
  var valid = true;
  var errors = [];

  if (password.length < 6 || password.length > 10) {
    valid = false;
    errors.push("Password must be between 6 and 10 characters");
  }

  if (!/^[a-zA-Z0-9]+$/.test(password)) {
    valid = false;
    errors.push("Password must consist only of letters and digits");
  }

  var digitCount = (password.match(/\d/g) || []).length;
  if (digitCount < 2) {
    valid = false;
    errors.push("Password must have at least 2 digits");
  }

  if (valid) {
    console.log("Password is valid");
  } else {
    errors.forEach(function (error) {
      console.log(error);
    });
  }
}

//validatePassword("logIn");
//validatePassword("MyPass123");
validatePassword("Pa$s$s");
