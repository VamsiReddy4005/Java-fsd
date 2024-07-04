document.addEventListener('DOMContentLoaded', () => {
    const bookingHistory = [
        // Simulated booking history data
        { customerId: '12345', bookingId: '987654321012', bookingDate: '2024-07-01', receiverName: 'John Doe', deliveredAddress: '123 Main St, Springfield', amount: '$10.00', status: 'Delivered' },
        // Add more records as needed
    ];

    const tbody = document.getElementById('bookingHistory');
    bookingHistory.forEach(record => {
        const tr = document.createElement('tr');
        Object.values(record).forEach(value => {
            const td = document.createElement('td');
            td.textContent = value;
            tr.appendChild(td);
        });
        tbody.appendChild(tr);
    });
});

function previousPage() {
    // Implement pagination logic
}

function nextPage() {
    // Implement pagination logic
}

function logout() {
    // Simulate logout action
    alert('Logged out successfully!');
    window.location.href = 'login.html';
}
