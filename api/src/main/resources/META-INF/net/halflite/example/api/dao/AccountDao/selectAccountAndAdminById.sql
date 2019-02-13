select
  account.id
  , account.email
  , account.display_name
  , account.status
  , admin.division
from
  account
  left outer join admin on admin.account_id = account.id
where
  account.id = /* id */1
