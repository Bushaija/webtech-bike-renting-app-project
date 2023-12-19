
const TextLink = ({paragraph, link, value}) => {
  return (
    <p className="flex gap-2">
      <span className="text-gray-500">
        {paragraph}
      </span>
      <a href={link} className="font-semibold underline">
        {value}
      </a>
    </p>
  )
}

export default TextLink