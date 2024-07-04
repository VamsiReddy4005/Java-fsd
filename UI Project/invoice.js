document.addEventListener('DOMContentLoaded', () => {
    // Assuming you fetch these details from the server or local storage
    const invoiceDetails = {
        receiverName: 'John Doe',
        receiverAddress: '123 Main St, Springfield',
        receiverPin: '123456',
        receiverMobile: '1234567890',
        parcelWeight: '500',
        parcelContents: 'Books',
        parcelDeliveryType: 'Express',
        parcelPackingPreference: 'Standard',
        parcelPickupTime: '2024-07-04 10:00 AM',
        parcelDropoffTime: '2024-07-05 02:00 PM',
        parcelServiceCost: '$10.00',
        parcelPaymentTime: '2024-07-04 09:00 AM'
    };

    document.getElementById('receiverName').textContent = invoiceDetails.receiverName;
    document.getElementById('receiverAddress').textContent = invoiceDetails.receiverAddress;
    document.getElementById('receiverPin').textContent = invoiceDetails.receiverPin;
    document.getElementById('receiverMobile').textContent = invoiceDetails.receiverMobile;
    document.getElementById('parcelWeight').textContent = invoiceDetails.parcelWeight;
    document.getElementById('parcelContents').textContent = invoiceDetails.parcelContents;
    document.getElementById('parcelDeliveryType').textContent = invoiceDetails.parcelDeliveryType;
    document.getElementById('parcelPackingPreference').textContent = invoiceDetails.parcelPackingPreference;
    document.getElementById('parcelPickupTime').textContent = invoiceDetails.parcelPickupTime;
    document.getElementById('parcelDropoffTime').textContent = invoiceDetails.parcelDropoffTime;
    document.getElementById('parcelServiceCost').textContent = invoiceDetails.parcelServiceCost;
    document.getElementById('parcelPaymentTime').textContent = invoiceDetails.parcelPaymentTime;
});
