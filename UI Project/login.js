function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const errorMessage = document.getElementById('error-message');

    // Validate password (at least one uppercase, lowercase, and special character)
    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\W).+$/;
    if (!passwordRegex.test(password)) {
        errorMessage.innerText = 'Password must contain at least one uppercase letter, one lowercase letter, and one special character.';
        return false;
    }

    // Simulate SQL query for user authentication
    /*
    SELECT * FROM users WHERE username = ? AND password = ?;
    */

    // Assuming authentication is successful
    window.location.href = 'dashboard.html'; // Redirect to dashboard
    return false;
}
