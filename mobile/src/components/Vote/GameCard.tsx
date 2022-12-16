import React from 'react';
import { View, Image, Text, Button, Alert } from 'react-native';

import { clientSendingVotes } from '../../api/api'
import { gameInterface } from '../../interfaces/gameInterface';

import { styles } from './styles';

const sendVote = (id: number) => {
  Alert.alert("Vote send!!", "Thanks for helping decide the Game of the Year", [{ text: "OK", onPress: () => clientSendingVotes(id) }])
}

export function GameCard(props: gameInterface | any) {
  return (
    <View style={styles.CardContainer} >
      <View>
        <Image source={{ uri: props.cover }} style={styles.card} />
      </View>

      <View style={styles.infoContainer}>
        <Text style={styles.label}>{props.name}</Text>
        <Button title="Vote" color="#9AC33C" onPress={() => sendVote(props.id)} />
      </View>
    </View>
  );
}

