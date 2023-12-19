import { Link } from "react-router-dom";

const Button = ({ value, round }) => {
  return (
    <button
      //onClick={onClick}
      type="submit"
      className={`w-[300px] border-2 border-black p-2 ${
        round ? round : "rounded"
      } text-[1.2rem] text-gray-200 bg-black font-semibold hover:bg-gray-200 hover:text-black focus:bg-gray-200 focus:text-black transition ease-in duration-500 round`}
    >
      {value ? value : "no-value"}
    </button>
  );
};


export const H1Button = ({ value, round }) => {
  return (
      <button
        type="submit"
        className={`w-[300px] border-2 border-black p-2 ${
          round ? round : "rounded"
        } text-[1.2rem] text-gray-200 bg-black font-semibold hover:bg-gray-200 hover:text-black focus:bg-gray-200 focus:text-black transition ease-in duration-500 round`}
      >
        {value ? value : "no-value"}
      </button>
  );
};


export const H2Button = ({onClick, value, link, round, opacity, bg, color }) => {
  return (
    <Link to={link}>
      <button
        onClick={onClick}
        className={`
        w-[125px] border-2 border-black p-2 
        ${bg?bg:"bg-black"}
        text-${color?color:"white"}
        text-white
        ${round ? round : "rounded"} 
        ${opacity?opacity:"opacity-1"} 
        text-[1.2rem] bg-black font-semibold hover:bg-gray-200 hover:text-black focus:bg-gray-200 focus:text-black transition ease-in duration-500 round`}
      >
        {value ? value : "no-value"}
      </button>
    </Link>
  );
};

export const H3Button = ({ value, link, round, opacity, bg, color }) => {
  return (
    <Link to={link}>
      <button
        className={`
        w-[125px] border-2 border-black p-2 
        ${bg?bg:"bg-black"}
        text-black
        ${round ? round : "rounded"} 
        ${opacity?opacity:"opacity-1"} 
        text-[1.2rem] bg-black font-semibold hover:bg-gray-200 hover:text-black focus:bg-gray-200 focus:text-black transition ease-in duration-500 round`}
      >
        {value ? value : "no-value"}
      </button>
    </Link>
  );
};

export default Button;
