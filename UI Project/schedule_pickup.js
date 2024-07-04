function schedulePickup() {
    const bookingId = document.getElementById('bookingId').value;
    const pickupDate = document.getElementById('pickupDate').value;
    const pickupTime = document.getElementById('pickupTime').value;

    // Save the scheduled pickup information
    // Simulated save action
    const pickupStatusDiv = document.getElementById('pickupStatus');
    pickupStatusDiv.innerHTML = `
        <p>Pickup scheduled successfully for Booking ID: ${bookingId}</p>
        <p>Date: ${pickupDate}</p>
        <p>Time: ${pickupTime}</p>
    `;
}
