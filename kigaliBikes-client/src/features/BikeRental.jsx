import { useState, useEffect } from 'react'
import { useNavigate, useParams } from "react-router-dom"
import { getOneBike, rentBike } from '../api/api.js';
import { Title, H2Button, H3Button, Row } from "../components";



const BikeRental = () => {
  const { id } = useParams();
  const navigate = useNavigate(); // Use usenavigate to navigate
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

  const handleRentBike = async () => {
    try {
      // Call rentBike method
      await rentBike({ bikeId: bikeDetails.id });
      // Redirect to PaymentForm.jsx after renting
      navigate('/PaymentForm'); // Update the path accordingly
    } catch (error) {
      console.error('Error renting bike:', error);
    }
  };

  if (!bikeDetails) {
    return <div>Loading...</div>; // You may want to render a loading state
  }



  return (
    <section className="h-[100vh] max-w-[560px]  flex flex-col justify-center items-center gap-[60px]">
    <header>
      <Title 
        title={"Bike Process"}
      />
    </header>
    <main className="w-[450px] flex flex-col items-center justify-center">
     <div className="container flex flex-col gap-4">
        <Row colOne={"Model"} colTwo={bikeDetails.model}/>
        <Row colOne={"Color"} colTwo={bikeDetails.color}/>
        <Row colOne={"PricePerHour"} colTwo={bikeDetails.pricePerHour}/>
        <Row colOne={"Status"} colTwo={bikeDetails.status === 0 ? "Available" : bikeDetails.status === 1 ? "Rented" : "Maintenance"}/>
      </div>
    </main>
    <footer className="flex items-center justify-center gap-36 ">
      <H3Button
        value={"Back"}
        color={"black"}
        bg={"bg-white"}
        opacity={60}
        link={`/bikes/${bikeDetails.id}`}
      />
      <H2Button
        value={"Confirm"}
        onClick={handleRentBike}
        link={`/payments/${bikeDetails.id}`}
      />   
    </footer>
  </section>
  )
}

export default BikeRental