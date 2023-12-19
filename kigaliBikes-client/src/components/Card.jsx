import { Link } from "react-router-dom";

const Card = ({ bikeImage, bikeName, link}) => {
  return (
    <Link to={link}>
      <div 
        className="card w-[250px] h-[250px] rounded-md m-4
        bg-blend-lighten hover:bg-blend-darken hover:cursor-pointer flex flex-col justify-center items-center relative
        "
      >
        <img src={bikeImage} alt="" className="h-[208px]"/>
        <p className="w-full border-b-2 border-black p-2 font-semibold italic">{bikeName}</p>
        <div className="h-full w-full absolute top-0 bg-black opacity-[4.2%] hover:opacity-0 transition ease-in duration-400 round rounded-lg"/>
      </div>
    </Link>
  )
}

export default Card;