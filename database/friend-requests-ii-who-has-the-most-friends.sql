WITH ids AS (
    SELECT requester_id AS id FROM RequestAccepted
    UNION
    SELECT accepter_id  AS id FROM RequestAccepted
),
cnts AS (
    SELECT
        i.id,
        SUM(CASE WHEN r.requester_id = i.id THEN 1 ELSE 0 END) +
        SUM(CASE WHEN r.accepter_id  = i.id THEN 1 ELSE 0 END) AS num
    FROM ids i
    LEFT JOIN RequestAccepted r
      ON r.requester_id = i.id OR r.accepter_id = i.id
    GROUP BY i.id
)
SELECT id, num
FROM (
    SELECT id, num, DENSE_RANK() OVER (ORDER BY num DESC) AS rk
    FROM cnts
) t
WHERE rk = 1;
