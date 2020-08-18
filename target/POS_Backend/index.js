document.querySelector(".myButton").addEventListener('click',pageReload);

function pageReload(){
	window.location.reload(true)
}


fetch("http://127.0.0.1:8080/POS_Backend/transactions",{
	method:'GET',
	headers:{'Content-Type':'application/json'}
})

	.then((response) => response.json())
	.then((data) => {
		
		
		
        data.forEach(element => {
			const table = document.querySelector("#mytable");
            const id =element.id;
            const amount=element.amount;
            const cardNumber=element.cardNumber;
            
			
            const row = `
            <tr>
			<td>${id}</td>
			<td>${amount} ksh</td>
			<td>${cardNumber}</td>
			</tr> `;   
			
			table.insertAdjacentHTML("beforeend",row)
            
		});
		
		
	}).catch((error)=>{
		console.log('There is an error')
	})
	
	
	




