import React, { useState } from 'react';

const ImageUploadAndDelete = () => {
  const [file, setFile] = useState(null);
  const [imageId, setImageId] = useState('');

  const handleFileChange = (event) => {
    setFile(event.target.files[0]);
  };

  const uploadImage = async () => {
    const formData = new FormData();
    formData.append('file', file);

    try {
      const response = await fetch('http://localhost:8080/images/upload', {
        method: 'POST',
        body: formData,
      });

      if (response.ok) {
        alert('Image uploaded successfully!');
      } else {
        alert('Failed to upload image');
      }
    } catch (error) {
      console.error('Error:', error);
      alert('An error occurred while uploading the image');
    }
  };

  const deleteImage = async () => {
    try {
      const response = await fetch(`http://localhost:8080/images/delete/${imageId}`, {
        method: 'DELETE',
      });

      if (response.ok) {
        alert('Image deleted successfully!');
      } else {
        alert('Failed to delete image');
      }
    } catch (error) {
      console.error('Error:', error);
      alert('An error occurred while deleting the image');
    }
  };

  return (
    <div>
      <h1>Image Upload</h1>
      <form encType="multipart/form-data">
        <input type="file" name="file" accept="image/*" onChange={handleFileChange} required />
        <button type="button" onClick={uploadImage}>
          Upload Image
        </button>
      </form>

      <h1>Image Delete</h1>
      <form>
        <label htmlFor="imageId">Image ID:</label>
        <input
          type="number"
          name="imageId"
          value={imageId}
          onChange={(e) => setImageId(e.target.value)}
          required
        />
        <button type="button" onClick={deleteImage}>
          Delete Image
        </button>
      </form>
    </div>
  );
};

export default ImageUploadAndDelete;
