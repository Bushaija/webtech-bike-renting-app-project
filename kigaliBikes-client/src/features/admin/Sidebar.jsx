import { Link } from "react-router-dom";

const Sidebar = () => {
    
  return (
    <div className="px-8 flex flex-col justify-center mt-[170px]">
      <div
        className={`w-72 border-2 border-black shadow-2xl h-[600px] p-5  pt-8 relative duration-300
        `}
      >
        {/* <img
          src={Control}
          className={`absolute cursor-pointer -right-3 top-9 w-7 border-dark-purple
          border-2 rounded-full`}
        /> */}
        <div className="main-logo shadow-xl rounded-full">
        <h1 className={`text-black ${
          open ? "text-[1.15rem]" : "text-[.8rem]"
        } font-bold border-l-[3px] border-black p-[5px] rounded-full `}>Kigali<span className='text-ora'>Bikes</span></h1>
        </div>

        <ul className="pt-12">
          <li className="flex gap-2 mb-8">
            {/* <img src={Chart_fill} alt="dashboard"/> */}
            <span className="text-md font-semibold text-black">Dasboard</span>
          </li>


          <li className="flex flex-col gap-2">
            <div className="flex gap-2">
              {/* <img src={Setting} alt="Properties"/> */}
              <span className="text-md font-semibold text-black">Users</span>
            </div>
            <ul className="ml-8">
              <li className="text-black text-sm font-semibold mb-[8px] hover:text-orange-400 focus:text-orange-400">
                <Link to="/">All Users</Link>
              </li>
              <li className="text-black text-sm font-semibold mb-[8px] hover:text-orange-400 focus:text-orange-400">
                <Link to="/">Update User</Link>
              </li>
            </ul>
          </li>

          <li className="flex flex-col gap-2">
            <div className="flex gap-2">
              {/* <img src={Setting} alt="Properties"/> */}
              <span className="text-md font-semibold text-black">Bikes</span>
            </div>
            <ul className="ml-8">
            <li className="text-black text-sm font-semibold mb-[8px] hover:text-orange-400 focus:text-orange-400">
                <Link to="/">New Bike</Link>
              </li>
              <li className="text-black text-sm font-semibold mb-[8px] hover:text-orange-400 focus:text-orange-400">
                <Link to="/">All Bikes</Link>
              </li>
              <li className="text-black text-sm font-semibold mb-[8px] hover:text-orange-400 focus:text-orange-400">
                <Link to="/">Update Bike</Link>
              </li>
              <li className="text-black text-sm font-semibold mb-[8px] hover:text-orange-400 focus:text-orange-400">
                <Link to="/">Delete Bike</Link>
              </li>
            </ul>
          </li>

          <li className="flex flex-col gap-2">
            <div className="flex gap-2">
              {/* <img src={Setting} alt="Properties"/> */}
              <span className="text-md font-semibold text-black">Rentals</span>
            </div>
            <ul className="ml-8">
              <li className="text-black text-sm font-semibold mb-[8px] hover:text-orange-400 focus:text-orange-400">
                <Link to="/">All Rentals</Link>
              </li>
              <li className="text-black text-sm font-semibold mb-[8px] hover:text-orange-400 focus:text-orange-400">
                <Link to="/">Cancel Rentals</Link>
              </li>
            </ul>
          </li>

          <li className="flex flex-col gap-2">
            <div className="flex gap-2">
              {/* <img src={Setting} alt="Properties"/> */}
              <span className="text-md font-semibold text-black">Payments</span>
            </div>
            <ul className="ml-8">
              <li className="text-black text-sm font-semibold mb-[8px] hover:text-orange-400 focus:text-orange-400">
                <Link to="/">All Payments</Link>
              </li>
              <li className="text-black text-sm font-semibold mb-[8px] hover:text-orange-400 focus:text-orange-400">
                <Link to="/">All Payments</Link>
              </li>
            </ul>
          </li>

          
        </ul>
      </div>
    </div>
  )
}

export default Sidebar