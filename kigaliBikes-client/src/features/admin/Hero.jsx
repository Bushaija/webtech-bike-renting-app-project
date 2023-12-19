// import { useState, useEffect } from 'react';
// import { HousesList, LandList } from '.';
// import { lands } from '../constants';
// import { useGetHouses } from '../utils';
import { BikesList } from "../";


const Hero = () => {

  return(
    <section className='flex flex-col bg-[#202020] rounded-[15px]'>
        <h2 className="font-bold text-2xl text-[#dedce4] m-8">All Bikes</h2>
        <div>
          <BikesList />
        </div>
    </section>
  )
}

export default Hero;