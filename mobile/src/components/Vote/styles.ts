import { StyleSheet } from "react-native";

export const styles = StyleSheet.create({
  CardContainer: {
    borderWidth: 2,
    padding: 10,
    borderBottomColor: "#fff",
    width: "100%",
    borderRadius: 8,
    flexDirection: "row",
    backgroundColor: "#404040",
  },
  card: {
    borderRadius: 10,
    width: 200,
    height: 300,
  },
  label: {
    fontSize: 22,
    color: "white",
    paddingBottom: 15,
    textAlign: "center",
  },
  infoContainer: {
    flex: 1,
    justifyContent: "flex-start",
    alignItems: "center",
    textAlign: "center",
    paddingTop: 20,
  },
});
