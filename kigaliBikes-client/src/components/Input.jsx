
const Input = ({placeholder, value, onChange, type = "text"}) => {
  console.log(value)
  return (
    <input 
        type={type} 
        placeholder={placeholder} 
        value={value}
        onChange={onChange}
        className="border-2 border-[#D2D2D2] w-[300px] p-[10px] placeholder:opacity-50 placeholder:text-[1.15rem] rounded px-4 outline-none focus:outline-2 focus:outline-black"
      />
  )
}

export default Input