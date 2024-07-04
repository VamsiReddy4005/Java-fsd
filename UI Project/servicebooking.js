function bookService() {
    // Perform form validation
    // Calculate and display service cost based on inputs
    const serviceCost = calculateServiceCost();
    document.getElementById('serviceCost').value = serviceCost;

    // Simulate SQL query for booking service
    /*
    INSERT INTO bookings (senderName, senderAddress, senderContact, receiverName, receiverAddress, receiverPinCode, receiverContact, parcelSize, parcelWeight, parcelContents, deliverySpeed, packagingPreferences, pickupDate, pickupTime, serviceCost) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
    */

    alert('Service booked successfully');
    // Redirect to acknowledgment page or show acknowledgment message
    return false;
}

function calculateServiceCost() {
    // Implement logic to calculate service cost based on inputs
    return 100; // Placeholder value
}
