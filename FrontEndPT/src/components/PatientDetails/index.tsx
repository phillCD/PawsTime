interface PatientDetailsProps {
  image: string;
  petName: string;
  type: string;
  breed: string;
  gender: string;
  ownerName: string;
}

export const PatientDetail = ({
  breed,
  gender,
  image,
  ownerName,
  petName,
  type,
}: PatientDetailsProps) => {
  return (
    <div>
      <img src={image} className="object-contain w-80 h-80 " />
      <div className=" flex flex-col bg-white rounded-2xl">
        <div className="bg-green-500 p-3 text-center rounded-md">
          <p className="font-bold text-white">Detalhes</p>
        </div>

        <div className="p-6">
          <h1 className="font-bold mb-6">{petName}</h1>
          <div className="flex flex-col gap-5 text-center">
            <p>{type}</p>
            <p>{breed}</p>
            <p>{gender}</p>
          </div>
          <p className="mt-6">{ownerName}</p>
        </div>
      </div>
    </div>
  );
};
