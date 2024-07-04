function trackParcel() {
    const bookingId = document.getElementById('bookingId').value;

    // Simulated tracking status based on booking ID
    const trackingStatus = {
        status: 'In Transit',
        estimatedDelivery: '2024-07-06'
    };

    const trackingStatusDiv = document.getElementById('trackingStatus');
    trackingStatusDiv.innerHTML = `
        <h3>Tracking Status</h3>
        <p>Status: ${trackingStatus.status}</p>
        <p>Estimated Delivery: ${trackingStatus.estimatedDelivery}</p>
    `;
}
