update salariat set salariu=salariu+0.1*salariu where Departament_idDepartament in 
(select distinct a.Departament_idDepartament from (select Departament_idDepartament from salariat) as a, (select Departament_idDepartament dept, count(idSalariat) numar_salariati from salariat group by Departament_idDepartament) b
where a.Departament_idDepartament=b.dept and b.numar_salariati=1);
