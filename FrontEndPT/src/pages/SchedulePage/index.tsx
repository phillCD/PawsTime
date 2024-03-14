import { useState } from 'react';
import "../../index.css"
import Calendar from 'react-calendar';
import { Value } from '../../@types/types';
import 'react-calendar/dist/Calendar.css';

export default function SchedulePage() {
  const [value, onChange] = useState<Value>(new Date());


  return(
    <div className='h-screen p-8 bg-slate-100'>
      <Calendar 
          onChange={onChange} 
          value={value}
          locale="pt-BR"
          formatShortWeekday={(_, date) => ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'][date.getDay()]}
      />
        <div className='bg-white '>

        </div>
    </div>
  )
}