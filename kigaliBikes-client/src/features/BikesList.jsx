import { useState, useEffect } from 'react'
import { Card, H2Button } from "../components"
import { bikes } from "../constants";
import { listAllBikes } from '../api/api.js';

const BikesList = () => {
  const [bikeData, setBikeData] = useState([]);

  useEffect(() => {
    // Fetch bike data when the component mounts
    const fetchBikes = async () => {
      try {
        const bikes = await listAllBikes();
        setBikeData(bikes);
      } catch (error) {
        console.error('Error fetching bikes:', error);
      }
    };

    fetchBikes();
  }, [])

  console.log("bikeData",bikeData);

  return (
    <section className="h-[100vh] max-w-[560px]">
      <nav className="border-black border p-[24px] w-full"></nav>
      <main className="p-4">
        <header>
          <h1 className="text-[22px] font-semibold">Available Bikes</h1>
        </header>
        <div className="cards grid grid-cols-2">
          {
            bikeData.map((bike) => (
              <div key={bike.id}>
                <Card
                  bikeImage={`/${bike.imagePath}`}
                  bikeName={bike.model}
                  link={`/bikes/${bike.id}`}
                />
              </div>
            ))
            }
        </div>
      </main>
      <footer className="flex justify-center items-center">
        <H2Button 
          value={"Fetch More"}
          link={"#"}
          round={"rounded-md"}
        />
      </footer>
    </section>
  )
}

export default BikesList