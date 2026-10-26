// =========================
// REGISTER
// =========================

function registerUser(event) {

    event.preventDefault();

    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const phone = document.getElementById("phone").value;

    const data =
        name + "," +
        email + "," +
        password + "," +
        phone;

    fetch("http://localhost:8080/register", {

        method: "POST",

        body: data

    })

    .then(response => response.text())

    .then(result => {

        document.getElementById("message").innerText = result;

    })

    .catch(error => {

        document.getElementById("message").innerText =
            "Registration failed!";

        console.log(error);

    });
}


// =========================
// LOGIN
// =========================

function loginUser(event) {

    event.preventDefault();

    const email =
        document.getElementById("email").value;

    const password =
        document.getElementById("password").value;

    const data =
        email + "," + password;

    fetch("http://localhost:8080/login", {

        method: "POST",

        body: data

    })

    .then(response => response.text())

    .then(result => {

        document.getElementById("message").innerText = result;

    })

    .catch(error => {

        document.getElementById("message").innerText =
            "Login failed!";

        console.log(error);

    });
}