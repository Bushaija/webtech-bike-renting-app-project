
const Row = ({colOne, colTwo}) => {
  return (
    <div className="row flex justify-between border-[#929191] p-2 border-b">
    <span className="text-[1.1rem] text-[#777575]">{colOne}</span>
    <span className="text-[1.1rem] font-semibold">{colTwo}</span>
  </div>
  )
}

export default Row