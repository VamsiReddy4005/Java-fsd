function searchStatus() {
    const customerId = document.getElementById('customerId').value;
    const bookingId = document.getElementById('bookingId').value;

    // Simulated package status based on customer ID and booking ID
    const packageStatus = {
        customerId: '12345',
        bookingId: '987654321012',
        status: 'Delivered',
        deliveryDate: '2024-07-04'
    };

    const packageStatusDiv = document.getElementById('packageStatus');
    packageStatusDiv.innerHTML = `
        <h3>Package Status</h3>
        <p>Customer ID: ${packageStatus.customerId}</p>
        <p>Booking ID: ${packageStatus.bookingId}</p>
        <p>Status: ${packageStatus.status}</p>
        <p>Delivery Date: ${packageStatus.deliveryDate}</p>
    `;
}
