import { useState, useEffect } from 'react'
import { useParams } from "react-router-dom"
import { Title, H2Button, H3Button, Row } from "../components";
//import { bikeDetails } from "../constants";
import { getOneBike } from '../api/api.js';


const BikeDetails = () => {
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
    return <div>Loading...</div>;
  }

  
  return (
    <section className="h-[100vh] max-w-[560px]  flex flex-col justify-center items-center gap-[60px]">
    <header>
      <Title 
        title={"Bike Details"}
      />
    </header>
    <main className="w-[450px] flex flex-col items-center justify-center">
      <div>
        <img src={bikeDetails.imagePath} className="w-[270px]" alt="" />
      </div>
      <div className="container flex flex-col gap-4">
        <Row colOne={"Model"} colTwo={bikeDetails.model}/>
        <Row colOne={"Color"} colTwo={bikeDetails.color}/>
        <Row colOne={"PricePerHour"} colTwo={bikeDetails.pricePerHour}/>
        <Row colOne={"Status"} colTwo={bikeDetails.status === 0 ? "Available" : bikeDetails.status === 1 ? "Rented" : "Maintenance"}/>
      </div>
    </main>
    <footer className="flex items-center justify-center gap-36 ">
      <H3Button
        value={"Cancel"}
        color={"black"}
        bg={"bg-white"}
        link={"/bikes"}
      />
      <H2Button
        value={"Book Bike"}
        link={`/rentals/bikes/${bikeDetails.id}`}
      />   
    </footer>
  </section>

  )
}

export default BikeDetails