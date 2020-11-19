alter table account
	add constraint account_pk
		primary key (account);

alter table history
  ADD CONSTRAINT account_fkey
  FOREIGN KEY (account) REFERENCES account (account);