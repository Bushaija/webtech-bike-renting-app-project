import { Link } from 'react-router-dom';

const NotFound = () => {
  return (
    <section className="flex flex-col items-center justify-center h-screen">
      <h1 className="text-4xl font-bold text-gray-800 mb-4">404 Not Found</h1>
      <p className="text-lg text-gray-600 mb-8">
       {" Oops! It looks like the page you're looking for does not exist."}
      </p>
      <Link to="/bikes" className="text-black font-semibold underline hover:underline">
        Go back to the home page
      </Link>
    </section>
  );
};

export default NotFound;
