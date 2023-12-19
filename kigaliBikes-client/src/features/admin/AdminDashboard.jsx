import { Hero, Sidebar } from '.';

const AdminDashboard = () => {
  return (
    <div className="flex">
      <div className=''>
        <Sidebar />
      </div>
      <div className="flex-1 px-7 py-12">
        <Hero />
      </div>
    </div>
  );
}

export default AdminDashboard;