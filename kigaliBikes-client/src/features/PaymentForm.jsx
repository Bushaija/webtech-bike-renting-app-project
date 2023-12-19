import { useState, useEffect } from 'react'
import { useParams } from "react-router-dom";
import { Title, Button, Input } from "../components";
import { getOneBike } from '../api/api.js';



const PaymentForm = () => {
    const { id } = useParams();
    const [bikeDetails, setBikeDetails] = useState(null);

    useEffect(() => {
      const fetchBikeDetails = async () => {
        try {
          const bike = await getOneBike(id);
          setBikeDetails(bike);
        } catch (error) {
          console.error(`Error fetching bike details for ID ${id}:`, error);
        }
      };

      fetchBikeDetails();
    }, [id]);

    if (!bikeDetails) {
      return <div>Loading...</div>; // You may want to render a loading state
    }

    return (
      <section className="h-[100vh] max-w-[560px]  flex flex-col justify-center items-center gap-[60px]">
      <header>
        <Title 
          title={"Payment Process"}
        />
      </header>
      <main className="w-full flex flex-col items-center justify-center gap-4">
        <div className="w-[300px] flex justify-center items-center gap-2 p-">
          <label htmlFor="paymentMethod">Select Payment Method</label>
          <select className="w-[120px] p-2" id="paymentMethod" name="paymentMethod">
            <option value="debitCard">Debit Card</option>
            <option value="creditCard">Credit Card</option>
          </select>
        </div>

        <Input placeholder={"Rental Cost"} value={bikeDetails.pricePerHour}/>
        <Input placeholder={"Card Number  4111 1111 1111"}/>
      </main>
      <footer className="flex flex-col items-center justify-center gap-2 ">
        <Button
          value={"Finish and Pay"}
          link={"#"}
        />   
      </footer>
    </section>
    )
}

export default PaymentForm