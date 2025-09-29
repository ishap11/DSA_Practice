# Write your MySQL query statement below
select 
    st.student_id , st.student_name , sb.subject_name , COUNT(ex.subject_name) AS attended_exams
from students st
cross join subjects sb
left join examinations ex
    ON st.student_id  = ex.student_id 
    AND sb.subject_name  = ex.subject_name 
GROUP BY st.student_id , st.student_name , sb.subject_name
order by st.student_id , sb.subject_name; 
