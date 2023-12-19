
const Title = ({title, center}) => {
  return (
    <h1
      className={`w-full ${center?center:"text-center"} text-[28px] font-semibold`}
    >{title ? title : "no-title specified"}</h1>
  )
}

export const H2Title = ({title, center}) => {
  return (
    <h2
      className={`w-full ${center?center:"text-center"} text-[22px] font-semibold`}
    >{title ? title : "no-title specified"}</h2>
  )
}

export default Title