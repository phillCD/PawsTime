import { useState } from 'react';
import "../../index.css"
import Calendar from 'react-calendar';
import { Value } from '../../@types/types';
import 'react-calendar/dist/Calendar.css';
import VetSelect from '../../components/VetSelect';
import Appointments from '../../components/Appointments';

export default function SchedulePage() {
  const [value, onChange] = useState<Value>(new Date());

  console.log("TEWSD  ", new Date(value!.toString()).getUTCDate());
  
  const dateObj = new Date(value!.toString())
  const day     = dateObj.getUTCDate();
  const month   = dateObj.toLocaleString('default', { month: 'long' }); // months from 1-12
  const year    = dateObj.getUTCFullYear();

  return(
    <div className='flex h-screen p-8 bg-slate-100 gap-5'>
      <div>
        <Calendar 
            onChange={onChange} 
            value={value}
            locale="pt-BR"
            className="rounded-md bg-green-500 items-center justify-center"
            tileClassName="items-center justify-center hover:opacity-20 cursor-pointer bg-red-500"
            formatShortWeekday={(_, date) => ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'][date.getDay()]}
        />
      </div>
      <div className='w-full gap-9'>
       <VetSelect />
       <div className='flex flex-1 flex-col bg-white mt-5 rounded-2xl p-6'>
          <div className='pb-2'>
            <p className='pl-2 pb-1'>{`${day} de ${month} de ${year}`}</p>
            <hr className='w-52 border-green-500'/>
          </div>
          <div className='flex flex-1 flex-col gap-2'>
            <Appointments />
            <Appointments />
            <Appointments />
            <Appointments />
            <Appointments />
            <Appointments />
            <Appointments />
            <Appointments />
            <Appointments />
            <Appointments />
            <Appointments />
            <Appointments />
            <Appointments />
            <Appointments />
          </div>
       </div>
      </div>
    </div>
  )
}