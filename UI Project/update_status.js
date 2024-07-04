function updateStatus() {
    const bookingId = document.getElementById('bookingId').value;
    const status = document.getElementById('status').value;

    // Update the delivery status based on booking ID
    // Simulated update action
    const updateMessageDiv = document.getElementById('updateMessage');
    updateMessageDiv.innerHTML = `
        <p>Status updated successfully for Booking ID: ${bookingId}</p>
        <p>New Status: ${status}</p>
    `;
}
