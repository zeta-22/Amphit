<script>
    var totalTickets = 140; // Numero totale di biglietti disponibili
    var maxTickets = Math.floor(totalTickets * 0.1); // Limite massimo del 10% dei biglietti
    var ticketCount = 0; // Contatore dei biglietti acquistati

    function showAlert(message) {
      var alertElement = document.querySelector('#alert');
      alertElement.textContent = message;
      alertElement.style.display = 'block';
    }

    function updateTicketCount() {
      var totalTicketsElement = document.querySelector('#totalTickets');
      var remainingTicketsElement = document.querySelector('#remainingTickets');
      var progressBarElement = document.querySelector('.ticket-progress');

      var remainingTickets = totalTickets - ticketCount;
      var progressPercentage = (remainingTickets / totalTickets) * 100;

      totalTicketsElement.textContent = totalTickets;
      remainingTicketsElement.textContent = remainingTickets;
      progressBarElement.style.width = progressPercentage + '%';

      if (ticketCount === totalTickets) {
        disableTicketPurchase();
      }
    }

    function disableTicketPurchase() {
  var ticketInput = document.querySelector('#ticketInput');
  var participateButton = document.querySelector('#participateButton');

  ticketInput.disabled = true;
  participateButton.disabled = true;
}

function participateRaffle() {
  var ticketInput = document.querySelector('#ticketInput');
  var tickets = parseInt(ticketInput.value);

  if (tickets >= 1 && tickets <= maxTickets && Number.isInteger(tickets)) {
    if (ticketCount + tickets > totalTickets) {
      var insufficientTicketsMessage = 'Non ci sono abbastanza biglietti disponibili.';
      showAlert(insufficientTicketsMessage);
      return;
    }

    for (var i = 0; i < tickets; i++) {
      ticketCount++; // Incrementa il contatore dei biglietti
      // Codice per assegnare e numerare il biglietto (ad esempio, salvare in un database o creare un elemento HTML)
    }

    var successMessage = 'Grazie per aver partecipato alla raffle! Hai acquistato ' + tickets + ' biglietti.';
    showAlert(successMessage);
    ticketInput.value = '';

    updateTicketCount(); // Aggiorna il numero dei biglietti rimanenti e la barra di avanzamento
  } else {
    var invalidTicketsMessage = 'Inserisci un numero di biglietti valido (superiore o uguale a 1 e massimo ' + maxTickets + ').';
    showAlert(invalidTicketsMessage);
  }
}



    function countdownTimerExpired() {
  var countdownTimerElement = document.querySelector('#countdownTimer');
  countdownTimerElement.style.display = 'none';

  var expiredMessageElement = document.createElement('p');
  expiredMessageElement.textContent = 'Il tempo per partecipare è scaduto.';
  document.querySelector('.countdown').appendChild(expiredMessageElement);

  disableTicketPurchase(); // Disabilita l'acquisto di biglietti
}
function disableTicketPurchase() {
  var ticketInput = document.querySelector('#ticketInput');
  var participateButton = document.querySelector('.button-partecipa');

  ticketInput.disabled = true;
  participateButton.disabled = true;
}

    function startCountdown() {
      var countdownTimerElement = document.querySelector('#countdownTimer');
      var countdownDaysElement = document.querySelector('#countdownDays');
      var countdownHoursElement = document.querySelector('#countdownHours');
      var countdownMinutesElement = document.querySelector('#countdownMinutes');
      var countdownSecondsElement = document.querySelector('#countdownSeconds');

      var countdownDate = new Date("2023-06-10T17:13:00Z"); // Data di scadenza del countdown
      var now = new Date().getTime();
      var distance = countdownDate.getTime() - now;

      if (distance < 0) {
        countdownTimerExpired();
        return;
      }

      var days = Math.floor(distance / (1000 * 60 * 60 * 24));
      var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
      var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
      var seconds = Math.floor((distance % (1000 * 60)) / 1000);

      countdownDaysElement.textContent = days;
      countdownHoursElement.textContent = hours;
      countdownMinutesElement.textContent = minutes;
      countdownSecondsElement.textContent = seconds;

      countdownTimerElement.style.display = 'block';

      setTimeout(startCountdown, 1000); // Aggiorna il countdown ogni secondo
    }

    updateTicketCount(); // Inizializza il numero dei biglietti rimanenti e la barra di avanzamento
    startCountdown(); // Avvia il countdown
  </script>