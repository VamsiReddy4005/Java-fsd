function processPayment() {
    // Show card details form based on payment mode
    const paymentMode = document.getElementById('paymentMode').value;
    if (paymentMode === 'credit') {
        document.getElementById('cardDetails').style.display = 'block';
    }
    return false;
}

function backToHome() {
    // Redirect to home or booking service page
    window.location.href = 'servicebooking.html';
}

function makePayment() {
    // Simulate SQL query for payment processing
    /*
    INSERT INTO payments (billAmount, paymentMode, cardNumber, cardHolderName, expiryDate, cvv) VALUES (?, ?, ?, ?, ?, ?);
    */

    alert('Payment successful');
    // Redirect to invoice page or show acknowledgment message with Booking ID
    return false;
}
