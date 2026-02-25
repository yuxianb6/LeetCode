import pandas as pd

def article_views(views: pd.DataFrame) -> pd.DataFrame:
    df=views
    df=df[(df["author_id"]==df["viewer_id"])]
    df = df[['author_id']].drop_duplicates()
    df=df.sort_values(by="author_id")
    df=df.rename(columns={"author_id":"id"})
    return df